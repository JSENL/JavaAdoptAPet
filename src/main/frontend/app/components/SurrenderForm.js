import React, { useState, useEffect } from "react"
import { Redirect } from "react-router-dom"
import _ from "lodash"
import ErrorList from "./ErrorList"

const SurrenderForm = (props) => {
  const [foundPetTypes, setFoundPetTypes] = useState([])

  useEffect(() => {
    fetch("/api/v1/pets")
    .then((response) => {
      if (response.ok) {
        return response
      } else {
        let errorMessage = `${response.status} (${response.statusText})`
        throw new Error(errorMessage)
      }
    })
    .then((result) => {
      return result.json()
    })
    .then((json) => {
      setFoundPetTypes(json)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])

  const defaultFormValues = {
    name: "",
    phoneNumber: "",
    email: "",
    petName: "",
    petAge: "",
    petType: "",
    petImgUrl: "",
    vaccinationStatus: "Pending",
  }

  const [newSurrender, setNewSurrender] = useState(defaultFormValues)
  const [errors, setErrors] = useState({})
  const [submitted, setSubmitted] = useState(false)
  const [toHome, setToHome] = useState(false)

  const isValidForSubmission = () => {
    let submitErrors = {}
    const requiredFields = [
      "name",
      "phoneNumber",
      "email",
      "petName",
      "petType",
      "petImgUrl",
    ]

    requiredFields.forEach((field) => {
      if (newSurrender[field].trim() === "") {
        submitErrors = {
          ...submitErrors,
          [field]: "is blank",
        }
      }
    })

    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleInputChange = (event) => {
    setNewSurrender({
      ...newSurrender,
      [event.currentTarget.id]: event.currentTarget.value,
    })
  }

  let typeId
  if (newSurrender.petType === "1") {
    typeId = 1
  } else {
    typeId = 2
  }

  let petType = foundPetTypes.find((pet) => pet.id === typeId)
  let isVaccinated = newSurrender.vaccinationStatus === "true"

  const addNewPet = (event) => {
    event.preventDefault()

    let formPayLoad = {
      name: newSurrender.name,
      phoneNumber: newSurrender.phoneNumber,
      email: newSurrender.email,
      petName: newSurrender.petName,
      petAge: newSurrender.petAge,
      petType: petType,
      petImgUrl: newSurrender.petImgUrl,
      vaccinationStatus: isVaccinated,
      applicationStatus: "Pending",
    }

    if (isValidForSubmission()) {
      fetch("/api/v1/new_pet", {
        method: "POST",
        body: JSON.stringify(formPayLoad),
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        if (response.ok) {
          setSubmitted(true)
        } else {
          let errorMessage = `${response.status} (${response.statusText})`
          throw new Error(errorMessage)
        }
      })
      .catch((error) => console.error(`Error in fetch: ${error.message}`))
    }
  }

  const petTypeList = foundPetTypes.map((petType) => {
    return (
        <option key={petType.type} value={petType.id}>
        {_.startCase(petType.type)}
        </option>
  )
  })

  if (submitted === false) {
    return (
        <form
    autoComplete="off"
    id="surrenderForm"
    className="callout form-format"
    onSubmit={addNewPet}
        >
        <h1 className="header-title">Surrender a Pet</h1>
    <ErrorList errors={errors} />
    <div>
    <label htmlFor="name">Name:</label>
    <input
    type="text"
    id="name"
    name="name"
    value={newSurrender.name}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="phoneNumber">Phone Number:</label>
    <input
    type="text"
    id="phoneNumber"
    name="phoneNumber"
    value={newSurrender.phoneNumber}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="email">Email:</label>
    <input
    type="text"
    id="email"
    name="email"
    value={newSurrender.email}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petName">Pet Name:</label>
    <input
    type="text"
    id="petName"
    name="petName"
    value={newSurrender.petName}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petAge">Pet Age:</label>
    <input
    type="text"
    id="petAge"
    name="petAge"
    value={newSurrender.petAge}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petType">Pet Type:</label>
    <select
    id="petType"
    onChange={handleInputChange}
    value={newSurrender.petType}
        >
        <option value="" />
        {petTypeList}
        </select>
        </div>

        <div>
        <label htmlFor="petImgUrl">Image URL:</label>
    <input
    type="text"
    id="petImgUrl"
    name="petImgUrl"
    value={newSurrender.petImgUrl}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="vaccinationStatus">Vaccination Status:</label>
    <select
    id="vaccinationStatus"
    onChange={handleInputChange}
    value={newSurrender.vaccinationStatus}
        >
        <option value="" />
        <option value="true">Vaccinated</option>
        <option value="false">Not Vaccinated</option>
    </select>
    </div>

    <input
    type="hidden"
    name="applicationStatus"
    id="applicationStatus"
    value="Pending"
        />

        <input type="submit" className="button" value="submit" />
        </form>
  )
  } else {
    return (
        <div>
        <h3 id="surrender-review">Your application is pending review.</h3>
    <div id="hidden">
        {setTimeout(() => setToHome(true), 3000)}
    {toHome ? <Redirect to="/" /> : null}
  </div>
    </div>
  )
  }
}

export default SurrenderForm

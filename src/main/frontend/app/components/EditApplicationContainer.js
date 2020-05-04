import React, { useState, useEffect } from "react"
import { Redirect } from "react-router-dom"

const EditApplicationContainer = (props) => {
  const [editApplication, setEditApplication] = useState({})
  const [submitted, setSubmitted] = useState(false)
  const [toHome, setToHome] = useState(false)

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
      let originalApplication = {
        name: applicant.name,
        phoneNumber: applicant.phoneNumber,
        email: applicant.email,
        petName: applicant.petName,
        petAge: applicant.petAge,
        petType: applicant.petType.id,
        petImgUrl: applicant.petImgUrl,
        vaccinationStatus: applicant.vaccinationStatus,
      }

      setEditApplication(originalApplication)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])

  let applicant = props.location.editProps.applicant

  const handleInputChange = (event) => {
    setEditApplication({
      ...editApplication,
      [event.currentTarget.id]: event.currentTarget.value,
    })
  }

  const saveApplicationEdit = (event) => {
    event.preventDefault()

    let typeId = parseInt(editApplication.petType)
    let petType = foundPetTypes.find((pet) => pet.id === typeId)

    let formPayLoad = {
      name: editApplication.name,
      phoneNumber: editApplication.phoneNumber,
      email: editApplication.email,
      petName: editApplication.petName,
      petAge: editApplication.petAge,
      petType: petType,
      petImgUrl: editApplication.petImgUrl,
      vaccinationStatus: editApplication.vaccinationStatus,
      applicationStatus: "Pending",
    }

    fetch(`/api/v1/edit_application/${applicant.id}`, {
      method: "PUT",
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
    onSubmit={saveApplicationEdit}
        >
        <h1 className="header-title">Edit Surrender Application</h1>
    <div>
    <label htmlFor="name">Name:</label>
    <input
    type="text"
    id="name"
    name="name"
    value={editApplication.name}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="phoneNumber">Phone Number:</label>
    <input
    type="text"
    id="phoneNumber"
    name="phoneNumber"
    value={editApplication.phoneNumber}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="email">Email:</label>
    <input
    type="text"
    id="email"
    name="email"
    value={editApplication.email}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petName">Pet Name:</label>
    <input
    type="text"
    id="petName"
    name="petName"
    value={editApplication.petName}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petAge">Pet Age:</label>
    <input
    type="text"
    id="petAge"
    name="petAge"
    value={editApplication.petAge}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="petType">Pet Type:</label>
    <select
    id="petType"
    onChange={handleInputChange}
    value={editApplication.petType}
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
    value={editApplication.petImgUrl}
    onChange={handleInputChange}
    />
    </div>

    <div>
    <label htmlFor="vaccinationStatus">Vaccination Status:</label>
    <select
    id="vaccinationStatus"
    onChange={handleInputChange}
    value={editApplication.vaccinationStatus}
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
        <h3 id="surrender-review">Application edit has been processed</h3>
    <div id="hidden">
        {setTimeout(() => setToHome(true), 2000)}
    {toHome ? <Redirect to="/" /> : null}
  </div>
    </div>
  )
  }
}

export default EditApplicationContainer

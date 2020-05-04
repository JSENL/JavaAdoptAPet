import React, { useState } from "react"
import { Link } from "react-router-dom"
import ErrorList from "./ErrorList"

const PendingSurrenderList = (props) => {
  const [deleted, setDeleted] = useState(false)
  const [submitted, setSubmitted] = useState(false)
  const [errors, setErrors] = useState({})
  const [story, setStory] = useState({
    story: "",
  })
  const {
    id,
    name,
    phoneNumber,
    email,
    petName,
    petAge,
    petType,
    petImgUrl,
    vaccinationStatus,
    applicationStatus,
  } = props.data

  let status
  if (vaccinationStatus === true) {
    status = "Up to Date"
  } else {
    status = "Not Up to Date"
  }

  let animalType
  if (petType.type === "reptile") {
    animalType = "Reptile"
  } else if (petType.type === "guineapig") {
    animalType = "Guinea Pig"
  }

  const handleInputChange = (event) => {
    setStory({
      ...story,
      [event.currentTarget.id]: event.currentTarget.value,
    })
  }

  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = ["story"]
    requiredFields.forEach((field) => {
      if (story[field].trim() === "") {
        submitErrors = {
          ...submitErrors,
          [field]: "is blank",
        }
      }
    })
    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const approveApplication = (event) => {
    event.preventDefault()
    let newPet = {
      name: petName,
      imgUrl: petImgUrl,
      age: petAge,
      vaccinationStatus: vaccinationStatus,
      adoptionStory: story.story,
      adoptionStatus: "Pending",
      petType: petType,
    }

    if (validForSubmission()) {
      fetch(`/api/v1/approve_pet/${props.data.id}`, {
        method: "POST",
        body: JSON.stringify(newPet),
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        if (response.ok) {
          setSubmitted(true)
          alert("Application Approved")
          window.location.href = "http://localhost:8080"
        } else {
          let errorMessage = `${response.statues} (${response.statusText})`,
              error = new Error(errorMessage)
          throw error
        }
      })
      .catch((error) => console.error(`Error in fetch: ${error.message}`))
    }
  }

  const deleteApplication = (event) => {
    event.preventDefault()
    let answer = prompt(
        "Are you sure you want to delete application?\nEnter 'Yes' to delete or 'No' to cancel."
    )
    if (answer.toLocaleLowerCase() === "yes") {
      let id = props.data.id
      fetch(`/api/v1/delete/${id}`, {
        method: "DELETE",
        body: JSON.stringify(props.data),
        headers: { "Content-Type": "application/json" },
      })
      .then((response) => {
        if (response.ok) {
          alert("Application deleted")
          setDeleted(true)
          window.location.href = "http://localhost:8080"
        } else {
          let errorMessage = `${response.status} (${response.statusText})`
          throw new Error(errorMessage)
        }
      })
      .catch((error) => console.error(`Error in fetch: ${error.message}`))
    }
  }

  return (
      <div className="add-pets-section">
      <div className="row ">
      <div className="small-6 columns about-pets-avatar">
      <img
  className="avatar-image pending-form-img"
  src={petImgUrl}
  alt={petName}
  />
  </div>

  <div className="small-6 columns about-pets div-pending-pet-applicant">
      <div className="about-pets-author">
      <p className="author-name">{petName}</p>
      <p className="author-location">Type of Animal: {animalType}</p>
  <p className="author-location">Vaccination Status: {status}</p>
  <p className="author-location">Pet Age: {petAge}</p>
  <p className="author-location">
      Application Status: {applicationStatus}
</p>
  </div>
  </div>

  <div className="small-6 columns about-pets div-pending-pet-applicant">
      <div className="about-pets-author">
      <p className="author-name">Applicant: {name}</p>
  <p className="author-location">Phone Number: {phoneNumber}</p>
  <p className="author-location">Email: {email}</p>
  <label htmlFor="adoptionStory">
      <ErrorList errors={errors} />
  <p className="author-location">Adoption Story:</p>
  <input
  type="text"
  name="story"
  id="story"
  value={story.story}
  onChange={handleInputChange}
  />
  </label>
  </div>
  </div>
  <div className="small-6 columns add-friend div-pending-button">
      <div className="add-friend-action">
      <Link
  to={{
    pathname: "/pending_applications",
        editProps: { applicant: props.data },
  }}
>
<button className="button primary small" value="Approved" id={id}>
      Edit Application
  </button>
  </Link>
  <button
  className="button secondary small"
  value="Delete"
  id={id}
  onClick={deleteApplication}
      >
      Delete Application
  </button>
  <button
  className="button primary small"
  value="Approved"
  id={id}
  onClick={approveApplication}
      >
      <i className="far fa-smile" aria-hidden="true"></i> Approve
  Application
  </button>
  </div>
  </div>
  </div>
  </div>
)
}

export default PendingSurrenderList

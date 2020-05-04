import React from "react"

const PendingAppList = (props) => {
  const {
    name,
    phoneNumber,
    email,
    homeStatus,
    applicationStatus,
    id,
    pet,
  } = props.data

  let status
  if (pet.vaccinationStatus === true) {
    status = "Up to Date"
  } else {
    status = "Not Up to Date"
  }

  const updateStatus = (event) => {
    event.preventDefault()
    const formPayLoad = {
      name: name,
      phoneNumber: phoneNumber,
      email: email,
      homeStatus: homeStatus,
      applicationStatus: event.currentTarget.value,
      pet: pet,
      id: event.currentTarget.id,
    }

    let status = event.currentTarget.value
    fetch(`/api/v1/approval_status/${id}`, {
      method: "PUT",
      body: JSON.stringify(formPayLoad),
      headers: { "Content-Type": "application/json" },
    })
    .then((response) => {
      if (response.ok) {
        alert("Application " + status)
        window.location.href = "http://localhost:8080/"
        return response
      } else {
        let errorMessage = `${response.statues} (${response.statusText})`,
            error = new Error(errorMessage)
        throw error
      }
    })
    .catch((error) => console.error(`Error in fetch: ${error.message}`))
  }

  return (
      <div className="add-pets-section">
      <div className="row ">
      <div className="small-6 columns about-pets-avatar">
      <img
  className="avatar-image pending-form-img"
  src={pet.imgUrl}
  alt={pet.name}
  />
  </div>

  <div className="small-6 columns about-pets div-pending-pet-applicant">
      <div className="about-pets-author">
      <p className="author-name">Pet: {pet.name}</p>
  <p className="author-location">Vaccination Status: {status}</p>
  <p className="author-location">
      Adoption Status: {applicationStatus}
</p>
  </div>
  </div>

  <div className="small-6 columns about-pets div-pending-pet-applicant">
      <div className="about-pets-author">
      <p className="author-name">Applicant: {name}</p>
  <p className="author-location">Phone Number: {phoneNumber}</p>
  <p className="author-location">Email: {email}</p>
  <p className="author-location">Home Status: {homeStatus}</p>
  <p className="author-location">
      Application Status: {applicationStatus}
</p>
  </div>
  </div>
  <div className="small-6 columns add-friend div-pending-button">
      <div className="add-friend-action">
      <button
  className="button primary small"
  value="Approved"
  id={id}
  onClick={updateStatus}
      >
      <i className="far fa-smile" aria-hidden="true"></i> Approve
      </button>
      <button
  className="button secondary small"
  value="Denied"
  id={id}
  onClick={updateStatus}
      >
      <i className="far fa-frown" aria-hidden="true"></i> Deny
      </button>
      </div>
      </div>
      </div>
      </div>
)
}
export default PendingAppList

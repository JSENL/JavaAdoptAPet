import React, { useState } from "react"

const PendingAppList = props => {
  const {
    pet_name,
    img_url,
    vaccination_status,
    adoption_story,
    adoption_status,
    person_name,
    phone_number,
    email,
    home_status,
    application_status,
    id
  } = props.data

  let status
  if (vaccination_status === true) {
    status = "Up to Date"
  } else {
    status = "Not Up to Date"
  }

  const updateStatus = event => {
    event.preventDefault()
    const approvalStatus = {
      status: event.currentTarget.value,
      id: event.currentTarget.id
    }
    debugger
    fetch("/api/v1/approvalStatus", {
      method: "POST",
      body: JSON.stringify(approvalStatus),
      headers: { "Content-Type": "application/json" }
    })
      .then(response => {
        if (response.ok) {
          return response
        } else {
          let errorMessage = `${response.statues} (${response.statusText})`,
            error = new Error(errorMessage)
          throw error
        }
      })
      .catch(error => console.error(`Error in fetch: ${error.message}`))
  }

  return (
    <div className="row add-pets-section">
      <div className="about-pets-avatar">
        <img className="avatar-image" src={img_url} alt={pet_name} />
      </div>

      <div className="small-12 medium-6 columns about-pets">
        <div className="about-pets-author">
          <p className="author-name">Pet Name: {pet_name}</p>
          <p className="author-location">Vaccination Status: {status}</p>
          <p className="author-location">Adoption Story: {adoption_story}</p>
          <p className="author-location">Adoption Status: {adoption_status}</p>
        </div>
      </div>

      <div className="small-12 medium-6 columns about-pets">
        <div className="about-pets-author">
          <p className="author-name">Applicant Name: {person_name}</p>
          <p className="author-location">Phone Number: {phone_number}</p>
          <p className="author-location">Email: {email}</p>
          <p className="author-location">Home Status: {home_status}</p>
          <p className="author-location">
            Application Status: {application_status}
          </p>
        </div>
      </div>

      <div className="small-12 medium-6 columns add-friend">
        <div className="add-friend-action">
          <button
            className="button primary small"
            value="Approved"
            id={id}
            onClick={updateStatus}
          >
            <i className="fa fa-user-plus" aria-hidden="true"></i>
            Approve
          </button>
          <button
            className="button secondary small"
            value="Denied"
            id={id}
            onClick={updateStatus}
          >
            <i className="fa fa-user-times" aria-hidden="true"></i>
            Deny
          </button>
        </div>
      </div>
    </div>
  )
}
export default PendingAppList

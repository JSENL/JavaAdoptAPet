import React from "react"

const PendingAppList = props => {
  console.log(props.data)
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
    application_status
  } = props.data

  let status
  if (vaccination_status === true) {
    status = "Up to Date"
  } else {
    status = "Not Up to Date"
  }

  return (
    <div className="add-pets-section">
      <div className="row ">
      <div className="small-6 columns about-pets-avatar">
        <img className="avatar-image pending-form-img" src={img_url} alt={pet_name} />
      </div>

      <div className="small-6 columns about-pets div-pending-pet-applicant">
        <div className="about-pets-author">
          <p className="author-name">{pet_name}</p>
          <p className="author-location">Vaccination Status: {status}</p>
          <p className="author-location">Adoption Story: {adoption_story}</p>
          <p className="author-location">Adoption Status: {adoption_status}</p>
        </div>
      </div>

      <div className="small-6 columns about-pets div-pending-pet-applicant">
        <div className="about-pets-author">
          <p className="author-name">Applicant: {person_name}</p>
          <p className="author-location">Phone Number: {phone_number}</p>
          <p className="author-location">Email: {email}</p>
          <p className="author-location">Home Status: {home_status}</p>
          <p className="author-location">
            Application Status: {application_status}
          </p>
        </div>
      </div>
      <div className="small-6 columns add-friend div-pending-button">
        <div className="add-friend-action">
          <button className="button primary small">
            <i className="fa fa-heart" aria-hidden="true"></i>
            Approve
          </button>
          <button className="button secondary small">
            <i className="fa fa-star" aria-hidden="true"></i>
            Deny
          </button>
        </div>
      </div>
      </div>
    </div>
  )
}
export default PendingAppList

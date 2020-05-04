import React from "react"

const AdoptedPet = (props) => {
	const { imgUrl, name, adoptionStatus, age, id } = props.pet

	if (adoptionStatus === "Approved") {
		status = "Adopted"
	}

	return (
			<div className="row add-pets-section">
			<div className="small-12 medium-6 columns about-pets">
			<div className="about-pets-avatar">
			<img className="avatar-image test" src={imgUrl} alt={name} />
	</div>
	<div className="about-pets-author">
			<p className="author-name">{name}</p>
			<p className="author-location">Age: {age}</p>
	<p className="author-mutual">
			<strong>{status}!</strong>{" "}
	</p>
	</div>
	</div>
	</div>
)
}

export default AdoptedPet

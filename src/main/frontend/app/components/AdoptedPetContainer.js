import React, { useState, useEffect } from "react"
import AdoptedPetListPage from "./AdoptedPetListPage"

const AdoptedPetContainer = (props) => {
  const [pets, setPets] = useState([])

  useEffect(() => {
    fetch(`/api/v1/adopted`)
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
      setPets(json)
    })
    .catch((error) => {
      console.log(error)
    })
  }, [])

  const listOfPets = pets.map((pet) => {
    return <AdoptedPetListPage key={pet.id} pet={pet} petType={props.petType} />
  })

  return (
      <div>
      <div className="pets-you-might-know">
      <div className="add-people-header">
      <h6 className="header-title">{props.petTypeName}</h6>
  {listOfPets}
</div>
  </div>
  </div>
)
}

export default AdoptedPetContainer

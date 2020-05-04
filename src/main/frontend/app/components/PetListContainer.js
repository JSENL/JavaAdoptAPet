import React, { useState, useEffect } from "react"
import PetListPage from "./PetListPage"

const PetListContainer = (props) => {
  const [pets, setPets] = useState([])

  useEffect(() => {
    fetch(`/api/v1/not_approved/${props.petType}`)
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
    return <PetListPage key={pet.id} pet={pet} petType={props.petType} />
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

export default PetListContainer

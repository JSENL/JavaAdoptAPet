import React, { useState, useEffect } from "react"
import PetInfo from "./PetInfo"

const ShowPage = (props) => {
  const [pet, setPet] = useState({})
  const [found, setFound] = useState(false)
  const petId = props.match.params.id
  const petType = props.match.params.petType
  let petTypeName = petType.substring(0, petType.length - 1)

  useEffect(() => {
    fetch(`/api/v1/${petTypeName}/${petId}`)
    .then((response) => {
      if (response.ok) {
        return response
      } else {
        let errorMessage = `${response.status} (${response.statusText})`,
            error = new Error(errorMessage)
        throw error
      }
    })
    .then((response) => response.json())
    .then((fetchedPet) => {
      setPet(fetchedPet)
      setFound(true)
    })
  }, {})

  return <PetInfo key={petId} pet={pet} found={found} />
}

export default ShowPage

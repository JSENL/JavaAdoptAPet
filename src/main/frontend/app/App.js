import React from "react"
import { Route, BrowserRouter, Link, Switch } from "react-router-dom"
import SurrenderForm from "./components/SurrenderForm"
import TypeOfPetsContainer from "./components/TypeOfPetsContainer"
import LoginPage from "./components/LoginPage"
import ListPageContainer from "./components/ListPageContainer"
import ShowPage from "./components/ShowPage"

const App = props => {
  return (
    <BrowserRouter>
      <div className="top-links">
        <nav className="top-bar topbar-responsive">
          <div className="top-bar-title">
            <Link to="/pets" id="topbar-site-title">
              <strong>Pet Adoption Site</strong>
            </Link>
          </div>
          <div id="topbar-responsive" className="topbar-responsive-links">
            <div className="top-bar-right">
              <ul className="menu simple vertical medium-horizontal">
                <li>
                  <Link to="/pets">Home</Link>
                </li>
                <li>
                  <Link to="/guineapigs">Guinea Pigs</Link>
                </li>
                <li>
                  <Link to="/reptiles">Reptiles</Link>
                </li>
                <li>
                  <Link to="/adoptions/new">Put up for Adoption</Link>
                </li>
                <li className="admin-button">
                  <Link to="/login">Login</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
      <div className="bottom">
        <Switch>
      <Redirect exact path="/" to="/pets" />
         <Route exact path="/pets" component={TypeOfPetsContainer} />
          <Route exact path="/pets/guineapigs" key={"gp"}>
            <PetListContainer
              petType={"guinea pig"}
              petTypeName={"Guinea Pigs"}
            />
          </Route>
          <Route exact path="/pets/reptiles" key={"lz"}>
            <PetListContainer petType={"reptile"} petTypeName={"Reptiles"} />
          </Route>
          <Route exact path="/adoptions/new" component={SurrenderForm} />
          <Route exact path="/login" component={LoginPage} />
          <Route exact path="/pets/:petType/:id" component={PetShowContainer} />
    <Route exact path="/pending_applications" component={EditApplicationContainer} />
  <Route exact path="/adopted" component={AdoptedPetContainer} />
  </Switch>
      </div>
    </BrowserRouter>
  )
}
export default App

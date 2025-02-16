import axios from "axios"
import { Container, Form } from "react-bootstrap"

export const Register:React.FC = () => {

    //TODO: gather user input like with our hypotenuse calculator

    //Hardcoding a new user registration with axios
    //axios is a way to send HTTP requests from React
    const register = async () => {

        //POST request with hardcoded user info
        const response = await axios.post("http://localhost:8080/auth/register", {
            username:"reactUser",
            password:"password"
        })
        .then(() => {
            alert("User created!")
            //TODO: actually create an user
        })
    }

    return(

        <Container>
          <div>
              <h1>New here? Create an Account for free!</h1>

              <div>
                  <Form.Control
                      type="text"
                      placeholder="username"
                      name="username"
                  />
              </div>
              <div>
                  <Form.Control
                      type="password"
                      placeholder="password"
                      name="password"
                  />
              </div>

              <div>
                <button onClick={register}>Create Account!</button>
              </div>
          </div>
      </Container>
  )
 
}
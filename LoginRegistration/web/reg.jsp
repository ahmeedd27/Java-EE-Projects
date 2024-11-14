
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Register Form by Bryan</title>
        <link rel="stylesheet" href="style.css" />
    </head>

    <body>
        <main>
            <form action="regcontrol" method="post">
                <h1>Register</h1>
                <fieldset>
                    <label>
                        <span>Name</span>
                        <input
                            type="text"
                            name="name"
                            placeholder="Name"
                            required
                            />
                    </label>
                    <label>
                        <span>Email</span>
                        <input type="email" name="email" placeholder="Email" required />
                    </label>
                    <label>
                        <span>Password</span>
                        <input
                            type="password"
                            name="password"
                            placeholder="Password"
                            required
                            />
                    </label>
                    <label>
                        <span>Contact</span>
                        <input
                            type="text"
                            name="contact"
                            placeholder="Contact"
                            required
                            />
                    </label>
                    <button type="submit">Register</button>
                </fieldset>
                <p>Already have an account? <a href="login.jsp">Login</a></p>
            </form>
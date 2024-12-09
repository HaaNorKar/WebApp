!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>

    <h2>Logg inn</h2>

    <p syle ="color: red"> ${loggetUt} </p> 
    <p> ${ugyldig} </p> 
    
    <form  method="post">
        <fieldset>
            <label for="tlf"> Mobil:</label> <input type="text" name="tlf" value="${tlf}" required minlength="8" maxlength="8" />
            <p style ="color: red"> ${ikkeFunnet}</p>
            <label for="passord">Passord:</label> <input type="password" name="passord"  required/>
            <p style ="color: red"> ${feilPassord}</p>
            <br><br><button type="submit">Logg inn</button>
    
        </fieldset>
    </form>
    
    

</body> 
</html>
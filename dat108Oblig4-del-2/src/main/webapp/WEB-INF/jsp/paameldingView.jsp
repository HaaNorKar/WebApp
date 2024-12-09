<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="no">
<head>



<link href="css/simple.css" rel="stylesheet" type="text/css">
    
 
    <title>Påmelding</title>
</head>

<body>
    <h2>Påmelding</h2>
    
    
    <p style="color:red;">${feilmeldinger}</p>
    <p style ="color:red"> ${finnes}</p>
    
    <form action = "paamelding" method="post">
    
        <fieldset>
        
            <label>Fornavn</label>
            <input required  type="text" name="fornavn" value="${deltager.fornavn}" minlength="2"  maxlength="20" />
            <br>
            <br>
            <label>Etternavn</label>
            <input required  type="text" name="etternavn" value="${deltager.etternavn}" minlength="2" maxlength="20"/>
            <br>
            <br>
            
            <label>Mobil (8 siffer)</label>
            <input type="text" name="tlf" value="${deltager.tlf}" required minlength="8" maxlength="8"/>
            <br>
            <br>
            
            <label>Passord</label>
            <input type="password" name="passord" required minlength="4" /> 
            <br><br>
            <label>Passord repetert</label>
            <input type="password" name="passordRepetert" required />
            <span style="color: red"> ${feilPassord}</span>


            
            <br>
            <br>
            <label>Kjønn</label> 
            <br>
            <input type="radio" name="kjonn" value="mann" required />mann
            <input type="radio" name="kjonn" value="kvinne" required />kvinne
                 
            <br><br><button type="submit">Meld meg på</button>
        </fieldset>
    </form>
</body>
</html>

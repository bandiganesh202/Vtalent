<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, label {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "GetCountryStateservlet",
                    method: "GET",
                    data: {operation: 'year'},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#year').append('<option value="' + value.id + '">' + value.name + '</option>')
                        });
                        $('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#year').append('<option>Year Unavailable</option>');
                    },
                    cache: false
                });


                $('#year').change(function () {
                    $('#actualYear').find('option').remove();
                    $('#actualYear').append('<option>Select State</option>'); 
                    $('#companyName').find('option').remove();
                    $('#companyName').append('<option>Select CompanyName</option>');

                    let cid = $('#year').val();
                    let data = {
                        operation: "ActualYear",
                        id: cid
                    };

                    $.ajax({
                        url: "GetCountryStateservlet",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#actualYear').append('<option value="' + value.id + '">' + value.name + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#actualYear').append('<option>ActualYear Unavailable</option>');
                        },
                        cache: false
                    });
                });
                
                $('#actualYear').change(function () {
                    $('#companyName').find('option').remove();
                    $('#companyName').append('<option>Select City</option>');

                    let sid = $('#actualYear').val();
                    let data = {
                        operation: "companyName",
                        id: sid
                    };

                    $.ajax({
                        url: "GetCountryStateservlet",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#companyName').append('<option value="' + value.id + '">' + value.name + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#companyName').append('<option>CompanyName Unavailable</option>');
                        },
                        cache: false
                    });
                });

            });
        </script>
</head>
<body>
<h2 align="center">Vehicle</h2>
<div class="container">
  <form action="/vehicle/success" method="post">
    <label for="fname">Year of Make</label>
  	<div class="input-field">
                        <select id="year">
                            <option>Select Year</option>
                        </select>
                    </div>
<br/>
    <label for="lname">Make of Car</label>
    <div class="input-field">
                        <select id="actualYear">
                            <option>Select ActualYear</option>
                        </select>
                    </div>
<br/>    
    <label for="address">Model of Car</label>
    <div class="input-field">
                        <select id="companyName">
                            <option>Select CompanyName</option>
                        </select>
                    </div>
<br/>
    <label for="city">Body Style</label>
    <select name="bodytype" id="bodytype">
		<option value="auto">Auto</option>
		<option value="health">Health</option>
		<option value="mortgage">Mortgage</option>
	</select>
<br/>    
    <label for="city">Vehicle Type</label>
    <select name="vehicletype" id="vehicletype">
		<option value="auto">Auto</option>
		<option value="health">Health</option>
		<option value="mortgage">Mortgage</option>
	</select>
<br/>
    <label for="dob">Estimated Mileage</label>
    <select name="mileage" id="mileage">
		<option value="auto">Auto</option>
		<option value="health">Health</option>
		<option value="mortgage">Mortgage</option>
	</select>
<br/>
    <input type="submit" value="Next">
  </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Fetch Rewards</title>

</head>
<body>

<form action="AddTransaction">

<h4>Enter the transaction to be Added:</h4>
<h5>Note: Enter Transactions as Multiple Individual JSON</h5>
<label>JSON INPUT:</label>

<textarea id="transactionDetails" name="transactionDetails" rows="5" cols="50">
</textarea>

<input type="submit">

</form>


<form action="SpendPoints">
<h4>Spend Points</h4>
<label>Enter the points you want to spend:</label>
<input type="text" name="points" id="points">
<input type="submit">
</form>

<form action="ShowBalances">
<h4>Show Balances</h4>
<input type="submit"> 
</form>

</body>
</html>
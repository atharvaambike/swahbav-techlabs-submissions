<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page
	import="java.util.*,com.bank.model.Transaction ,java.text.SimpleDateFormat"%>
<html>
<head>
<title>Passbook</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="nav">
		<a href="<%=request.getContextPath()%>/jsp/customer_dashboard.jsp">Back</a>
	</div>
	<div class="card">
		<h2>Passbook</h2>
		<form method="get" action="passbook">
			<label>From</label> <input type="date" name="from"
				value="<%=request.getAttribute("from")%>"> <label>To</label>
			<input type="date" name="to" value="<%=request.getAttribute("to")%>">
			<button type="submit">Filter</button>
		</form>
		<table>
			<tr>
				<th>Date</th>
				<th>Type</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Counterparty</th>
			</tr>
			<%
			List<Transaction> Transactions = (List<Transaction>) request.getAttribute("Transactions");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			for (Transaction t : Transactions) {
			%>
			<tr>
				<td><%=sdf.format(t.getCreatedAt())%></td>
				<td><%=t.getType()%></td>
				<td><%=t.getAmount()%></td>
				<td><%=t.getDescription()%></td>
				<td><%=t.getCounterpartyAccount() == null ? "" : t.getCounterpartyAccount()%></td>

			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>

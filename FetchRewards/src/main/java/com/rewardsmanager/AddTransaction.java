package com.rewardsmanager;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Servlet implementation class AddTransaction
 */
@WebServlet("/AddTransaction")
public class AddTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Fetch the user input
		String input = request.getParameter("transactionDetails");
		//Spilt based on new line character
		String data[] = input.split("\n");
		
		//For transaction details as JSON
		JSONArray transactionArray = new JSONArray();
		JSONArray sortedTransactionArray = new JSONArray();
		
		//For Holding Final balances
		HashMap<String,Integer> balances = new HashMap<>(); 
		//Collections is used for sorting by date 
		List<JSONObject> jsonValues = new ArrayList<JSONObject>();
		
		//For passing the data objects between multiple servlets
		HttpSession session = request.getSession();
		boolean error = false;
		//Initializing data structures
		for(int i = 0; i < data.length; i++) {
			try {
			JSONObject obj = new JSONObject(data[i]);
			transactionArray.put(obj);
			
			if(balances.containsKey(obj.getString("payer"))) {
				balances.put(obj.getString("payer"), balances.get(obj.getString("payer"))+obj.getInt("points"));
			}else {
				balances.put(obj.getString("payer"), obj.getInt("points"));
			}
			}catch(Exception e) {
				response.getWriter().append("Invalid data Format.");
				error = true;
			}
		}
		
		if(!error) {
		//Initialize list for sorting purposes
		for(int i = 0; i < transactionArray.length(); i++) {
			jsonValues.add(transactionArray.getJSONObject(i));
		}
		
		//Sorting transactions by date
		Collections.sort(jsonValues, new Comparator<JSONObject>() {

			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				// TODO Auto-generated method stub
				ZonedDateTime date1 = ZonedDateTime.parse(o1.getString("timestamp"));
				ZonedDateTime date2 = ZonedDateTime.parse(o2.getString("timestamp"));
				return date1.compareTo(date2);
			}
			
		});
		
		//For maintaining sorted transaction by timestamp, oldest first
		for(int i = 0; i < transactionArray.length(); i++) {
			sortedTransactionArray.put(jsonValues.get(i));
		}

		session.setAttribute("transaction", sortedTransactionArray);
		session.setAttribute("balances", balances);
		
		response.getWriter().append("Transaction Details are Added, Please Click On the Back Button on the browser").append(request.getContextPath());
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

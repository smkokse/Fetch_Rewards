package com.rewardsmanager;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class SpendPoints
 */
@WebServlet("/SpendPoints")
public class SpendPoints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpendPoints() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Fetching current session
		int points = 0;
		HttpSession session = request.getSession();
		JSONArray sortedTransactionArray = (JSONArray) session.getAttribute("transaction");
		HashMap<String, Integer> balances = (HashMap<String, Integer>) session.getAttribute("balances");
		//For returning the output on spend point invocation
		HashMap<String, Integer> subMap = new HashMap<>();
		
		
		if(balances == null ) {
			response.getWriter().append("Please ADD the transaction details");

		}else 
		{
		//For fetching the values of points to be spend 
		try {
		points = Integer.parseInt(request.getParameter("points"));
		}
		catch(Exception e) {
			response.getWriter().append("Please Input Numerical Characters");
		}
		
		int sum = 0;
		
		for(int s: balances.values()) {
			sum+=s;
		}
		
		if(points > sum ) {
			response.getWriter().append("Available points are less than points requested to spend");

		}else {
		
		for(int i = 0; i < sortedTransactionArray.length(); i++) {
			
			int diff;
			//Object to hold the oldest transactions to deduct the points from
			JSONObject obj = (JSONObject) sortedTransactionArray.get(i);
			//condition to stop execution of the loop once all the points are spend
			if(points == 0)
				break;
			//Calculation of points deduction
			if(points - obj.getInt("points") >= 0) {
				diff = obj.getInt("points");
				points = points - obj.getInt("points");
			}
			else {
				diff = points;
				points = 0;
			}
			//Calculation of point differences to be returned to the users after spending the points
			if(subMap.containsKey(obj.getString("payer"))) {
				subMap.put(obj.getString("payer"), subMap.get(obj.get("payer"))+diff);
			}else {
				subMap.put(obj.getString("payer"), diff);
			}
			
		}
		

		
		for(int i = 0; i < subMap.size(); i++) {
			//subMap.get(subMap.keySet().toArray()[i]);
			subMap.put((String)subMap.keySet().toArray()[i], subMap.get(subMap.keySet().toArray()[i])*-1);
			balances.put((String)subMap.keySet().toArray()[i], balances.get(subMap.keySet().toArray()[i])+subMap.get(subMap.keySet().toArray()[i]));

		}

		

		response.getWriter().append(""+new JSONObject(subMap));
		}
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

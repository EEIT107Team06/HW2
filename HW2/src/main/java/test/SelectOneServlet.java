package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test/selectOne.do")
public class SelectOneServlet extends HttpServlet {

	private static final long serialVersionUID = 926100030570194966L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");

		// 讀取使用者所輸入，由瀏覽器送來的欄位內的資料
		String item = request.getParameter("item");
		
		// 檢查使用者所輸入的資料	
		if (item == null || item.trim().length() == 0) {
			errorMessage.put("item", "必須輸入");
		}

		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/test/InsertForm.jsp");
			rd.forward(request, response);
			return;
		}
		
		// 封裝輸入資料		
			
			try {
				MemberDao dao = new MemberDao();				
				dao.select(item);	
				session.setAttribute("success", "查詢");
					RequestDispatcher rd = request.getRequestDispatcher("/test/Success.jsp");
					rd.forward(request, response);
					return;				
			} catch (Exception e) {	
				e.printStackTrace();
				return;
			}
	

		}
	}


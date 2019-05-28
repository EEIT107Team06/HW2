package test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test/insert.do")
public class InsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1675364700044482133L;

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
		String statisticalItem = request.getParameter("statisticalItem");
		String item = request.getParameter("item");
		String samples = request.getParameter("samples");
		String under2w = request.getParameter("under2w");
		String over2w = request.getParameter("over2w");
		String over3w = request.getParameter("over3w");
		String over4w = request.getParameter("over4w");
		String over5w = request.getParameter("over5w");

		// 檢查使用者所輸入的資料
		Integer iSamples = null;
		BigDecimal bUnder2w = null;
		BigDecimal bOver2w = null;
		BigDecimal bOver3w = null;
		BigDecimal bOver4w = null;
		BigDecimal bOver5w = null;
		
		if (statisticalItem == null || statisticalItem.trim().length() == 0) {
			errorMessage.put("statisticalItem", "必須輸入");
		}

		if (item == null || item.trim().length() == 0) {
			errorMessage.put("item", "必須輸入");
		}

		if (samples != null && samples.trim().length() > 0) {
			try {
				iSamples = Integer.parseInt(samples.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("samples", "必須輸入數字");
			}
		} else {
			errorMessage.put("samplesBlank", "必須輸入");
		}

		if (under2w != null && under2w.trim().length() > 0) {
			try {
				bUnder2w = new BigDecimal(under2w.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("under2w", "必須輸入數字");
			}
		} else {
			errorMessage.put("under2wBlank", "不能空白");
		}

		if (over2w != null && over2w.trim().length() > 0) {
			try {
				bOver2w = new BigDecimal(over2w.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("over2w", "必須輸入數字");
			}
		} else {
			errorMessage.put("over2wBlank", "不能空白");
		}

		if (over3w != null && over3w.trim().length() > 0) {
			try {
				bOver3w = new BigDecimal(over3w.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("over3w", "必須輸入數字");
			}
		} else {
			errorMessage.put("over3wBlank", "不能空白");
		}

		if (over4w != null && over4w.trim().length() > 0) {
			try {
				bOver4w = new BigDecimal(over4w.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("over4w", "必須輸入數字");
			}
		} else {
			errorMessage.put("over4wBlank", "不能空白");
		}

		if (over5w != null && over5w.trim().length() > 0) {
			try {
				bOver5w = new BigDecimal(over5w.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("over5w", "必須輸入數字");
			}
		} else {
			errorMessage.put("over5wBlank", "不能空白");
		}

		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/test/InsertForm.jsp");
			rd.forward(request, response);
			return;
		}

		// MemberBean 扮演封裝輸入資料的角色
		MemberBean mb = new MemberBean(statisticalItem, item, iSamples, bUnder2w, bOver2w, bOver3w, bOver4w, bOver5w);
		try {
			MemberDao dao = new MemberDao();
			dao.insertMember(mb);
			session.setAttribute("memberBean", mb);
			session.setAttribute("success", "新增");			

			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request.getRequestDispatcher("/test/Success.jsp");

			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("item", "細項重複，請重新輸入");
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/test/InsertForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}

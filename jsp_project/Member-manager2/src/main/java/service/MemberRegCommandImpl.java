package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {
			int result=MemberRegService.getInstance().regMember(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/reg_view.jsp";
	}

}

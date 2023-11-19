package com.gnjBook.controller.admin;

import com.gnjBook.dto.Fileboard;
import com.gnjBook.model.FileboardDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@WebServlet("/FileboardAddPro.do")
public class FileboardAddProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        ServletContext application = request.getServletContext();

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            try {
                String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
                int maxSize = 1024*1024*10;     //10MB
                String encoding = "UTF-8";

                MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
                Fileboard file = new Fileboard();

                file.setTitle(mr.getParameter("title"));
                file.setContent(mr.getParameter("content"));

                File upfile = null;
                Enumeration files = mr.getFileNames();

                int idx = 1;
                String item;
                String oriFile = "";
                String fileName = "";
                while(files.hasMoreElements()) {
                    item = (String) files.nextElement();
                    oriFile = mr.getOriginalFileName(item); //실제 첨부된 파일경로와 이름
                    fileName = mr.getFilesystemName(item);  //파일이름만 추출
                    if(fileName!=null) {
                        upfile = mr.getFile(item); //실제 업로드
                        if (upfile.exists()) {
                            long filesize = upfile.length();
                            if(idx==1) {
                                file.setFilename3(upfile.getName());
                            } else if(idx==2){
                                file.setFilename2(upfile.getName());
                            } else if(idx==3){
                                file.setFilename1(upfile.getName());
                            }
                            msg = "파일 업로드 성공";
                        } else {
                            msg = "파일 업로드 실패";
                        }
                    }
                    idx++;
                }

                FileboardDAO dao = new FileboardDAO();
                int cnt = dao.fileboardUpload(file);

                List<Fileboard> fileboardList = new ArrayList<>();

                if(cnt>0){
                    System.out.println("성공적으로 추가되었습니다.");
                    String path = request.getContextPath();
                    response.sendRedirect(path+"/FileboardListAdmin.do");
                } else {
                    System.out.println("오류로 인해 제대로 처리되지 않았습니다.");

                    response.sendRedirect("/FileboardAdd.do");
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}


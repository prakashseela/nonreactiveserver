package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@SpringBootApplication
public class NonReactiveServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonReactiveServerApplication.class, args);
	}


	@Controller
	class NonReactiveController {

//		@RequestMapping("/tweets")
//		public StreamingResponseBody handleRequest () {
//
//			return out -> {
//                while (true) {
//                    //System.out.println("Start");
//                    out.write("Hello World".getBytes());
//                    out.flush();
//                    System.out.println("@@@Start@@@");
//                }
//            };
//		}

		@RequestMapping("/tweets")
		public void handleRequest (HttpServletRequest req, HttpServletResponse resp) throws IOException {

			req.startAsync(req,resp);
			ServletOutputStream outputStream = resp.getOutputStream();
			while (true){
				try{
					outputStream.write("Hello World".getBytes());
					outputStream.flush();
				}
				finally {

				}
			}
		}
	}
}

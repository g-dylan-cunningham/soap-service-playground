package com.in28minutes.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.in28minutes.courses.CourseDetails;
import com.in28minutes.courses.GetCourseDetailsRequest;
import com.in28minutes.courses.GetCourseDetailsResponse;


@Endpoint
public class CourseDetailsEndpoint {
	
	// create method
	// input - request - GetCourseDetailsRequest - already named
	// output - response - GetCourseDetailsResponse - already named
	
	// we've annotated the class as an Endpoint. What other details do we specify?
		// if a request comes with this namespace: http://in28minutes.com/courses
	 	// and this name: GetCourseDetailsRequest
		// we need to define this in the PayloadRoot annotation
	// we also need to take the request xml and map it to a java class
		// do that with RequestPayload annotation
	// we also need to respond with an xml that comes from a pojo
		// do that with @ResponsePayload
	
	@PayloadRoot(namespace="http://in28minutes.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices Course");
		courseDetails.setDescription("That would be a wonderful course wouldn't it?");
		response.setCourseDetails(courseDetails);
		return response;
	}
	
}

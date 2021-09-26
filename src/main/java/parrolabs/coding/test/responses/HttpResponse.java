package parrolabs.coding.test.responses;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponse {

    private String message;
    private Object object;
    private HttpStatus httpStatus;

    public HttpResponse(String message, Object object, HttpStatus httpStatus) {
	this.message = message;
	this.object = object;
	this.httpStatus = httpStatus;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public Object getObject() {
	return object;
    }

    public void setObject(Object object) {
	this.object = object;
    }

    public HttpStatus getHttpStatus() {
	return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
	this.httpStatus = httpStatus;
    }

    public ResponseEntity<Map<String, Object>> build() {
	Map<String, Object> responseMap = new HashMap<>();
	responseMap.put("message", message);
	responseMap.put("object", object);
	return new ResponseEntity<>(responseMap, httpStatus);
    }

}

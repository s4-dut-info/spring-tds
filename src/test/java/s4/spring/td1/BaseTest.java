package s4.spring.td1;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.ContentResultMatchers;

@AutoConfigureMockMvc
public abstract class BaseTest {
	@Autowired
	private MockMvc mvc;

	protected ResultActions page;

	protected void doRequest(String method, String url, MediaType mediaType) throws Exception {
		switch (method) {
		case "get":
			page = this.mvc.perform(get(url).contentType(mediaType));
			break;
		case "post":
			page = this.mvc.perform(post(url).contentType(mediaType));
			break;
		case "put":
			page = this.mvc.perform(put(url).contentType(mediaType));
			break;
		case "delete":
			page = this.mvc.perform(delete(url).contentType(mediaType));
			break;
		case "head":
			page = this.mvc.perform(head(url).contentType(mediaType));
			break;
		case "patch":
			page = this.mvc.perform(patch(url).contentType(mediaType));
			break;
		case "options":
			page = this.mvc.perform(options(url).contentType(mediaType));
			break;
		default:
			break;
		}

	}

	protected void doRequest(String method, String uri) throws Exception {
		this.doRequest(method, uri, MediaType.TEXT_HTML);
	}

	protected void doGet(String uri) throws Exception {
		this.doRequest("get", uri, MediaType.TEXT_HTML);
	}

	protected void doPost(String uri) throws Exception {
		this.doRequest("post", uri, MediaType.TEXT_HTML);
	}

	protected void doGet(String uri, MediaType mediaType) throws Exception {
		this.doRequest("get", uri, mediaType);
	}

	protected void doPost(String uri, MediaType mediaType) throws Exception {
		this.doRequest("post", uri, mediaType);
	}

	protected ContentResultMatchers getPageContent() {
		return content();
	}

	protected ResultMatcher pageContentEquals(String text) {
		return content().string(text);
	}

	protected ResultMatcher pageContentContains(String text) {
		return content().string(containsString(text));
	}

	protected ResultMatcher pageContentContainsIgnoringCase(String text) {
		return content().string(containsStringIgnoringCase(text));
	}

}

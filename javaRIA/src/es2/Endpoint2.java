package es2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import es2.BlogPost;
import es2.BlogPostDAO;

@Path("/blogposts")
public class Endpoint2 {
	@POST
	public Response saveBlogPost(@FormParam("text") String text,
			@FormParam("title") String title) throws URISyntaxException {
		
		BlogPost blogPost = new BlogPost();
		blogPost.setText(text);
		blogPost.setTitle(title);
		
		int id = BlogPostDAO.getInstance().saveBlogPost(blogPost);
		
		return Response
				.status(Status.CREATED)
				.location(
						new URI("http://localhost:8080/javaRIA/rest/blogposts/"
								+ id)).build();
	
	}

	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BlogPost getBlogPost(@PathParam("id") String id) {
		
		return BlogPostDAO.getInstance().getBlogPost(Integer.parseInt(id));
	
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BlogPost> getBlogPosts() {
		
		return BlogPostDAO.getInstance().getBlogPosts();
	
	}

}

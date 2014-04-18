package es2;

import java.util.ArrayList;
import java.util.List;
import es2.BlogPost;


public class BlogPostDAO {
	
	private static BlogPostDAO instance = null;
	private int maxID = 0;
	private List<BlogPost> blogPosts = new ArrayList<>();

	public static BlogPostDAO getInstance() {
		
		if (instance == null) {
			
			instance = new BlogPostDAO();
		
		}
		
		return instance;
	
	}

	
	private BlogPostDAO() {
	
	}

	
	public int saveBlogPost(BlogPost newBlogPost) {
		
		maxID++;
		
		newBlogPost.setId(maxID);
		
		this.blogPosts.add(newBlogPost);
		
		return maxID;
	
	}

	
	public BlogPost getBlogPost(int id) {
	
		for (BlogPost post : blogPosts) {
		
			if (post.getId() == id) {
		
				return post;
			
			}
		
		}
		
		return null;
	
	}

	
	public BlogPost deleteBlogPost(int id) {
	
		BlogPost toBeRemoved = getBlogPost(id);
	
		if (toBeRemoved != null) {
		
			this.blogPosts.remove(toBeRemoved);
		
		}
		
		return toBeRemoved;
	
	}

	
	public List<BlogPost> getBlogPosts() {

		return this.blogPosts;
	
	}


}

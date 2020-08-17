package behavioral;

/*
 * aka - Snapshot/Deep_Copy
 * to restore state of an object to a previous state
 * Example :: 
 * 1> Deep Copy of JSON before modifying and evaluating difference between two JSON
 * 2> CTRL+Z in editors.
 * 3> DB RollBack 
 */
public class Memento_Simple {

	public static void main(String[] s) {

		Article article = new Article(1, "Article-1");
		article.setContent("Atricle-1 content..........");

		ArticleMemento articleSnapshot = article.createMemento(); //IMP

		System.out.println("Actual Article \t\t\t\t\t\t " + article);
		System.out.println("Article Copy/Snapshot/Memento \t\t\t\t " + articleSnapshot);

		article.setContent("Article-1 Updated Content.......");

		System.out.println("Actual Article (Updated) \t\t\t\t " + article);

		article.restore(articleSnapshot); //IMP
		
		System.out.println("Restored Article from Copy/Snapshot/Memento \t\t " + article);
	}
}

class Article 
{
	private long id; private String title, content;

	public Article(long id, String title) {//Create new Instance
		super();
		this.id = id; this.title = title;
	}

	public long getId() {return id; }
	public void setId(long id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }

	public ArticleMemento createMemento() { //Create DEEP_COPY/SNAPSHOT instance.
		return new ArticleMemento(id, title, content);
	}

	public void restore(ArticleMemento m) { // Create/Restore from COPY/SNAPSHOT
		this.id = m.getId(); this.title = m.getTitle(); this.content = m.getContent();
	}

	@Override
	public String toString() { return "[id=" + id + ", title=" + title + ", content=" + content + "]"; }
}

class ArticleMemento {

	private long id; private String title, content;//Same as original Class fields.

	public ArticleMemento(long id, String title, String content) {
		this.id = id; this.title = title; this.content = content;
	}

	//NO MUTABILITY ALLOWED :: Only getter, no setter. Memento/Snapshot has to be created by Constructor only.
	public long getId() { return id; }
	public String getTitle() { return title; }
	public String getContent() { return content; }

	@Override
	public String toString() { return "[id=" + id + ", title=" + title + ", content=" + content + "]"; }
}

/*
 *  
 */

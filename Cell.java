import java.util.*;

public class Cell {
	private List<Tangible> tangibles;
	private List<Reaction> reactions;
	
	public Cell(Tangible tangible){
		this.tangibles = new ArrayList<Tangible>();
		this.reactions = new ArrayList<Reaction>();
		this.tangibles.add(tangible);
	}
	public Cell(List<Tangible> listTangible){
		this.tangibles = listTangible;
	}
	
	
	
	
	public List<Tangible> getListTangibles() {
		return tangibles;
	}
	public void setListTangibles(List<Tangible> tangibles) {
		this.tangibles = tangibles;
	}
	public List<Reaction> getListReactions() {
		return reactions;
	}
	public void setListReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
	
	
	public void addTangible(Tangible tangible){
		this.tangibles.add(tangible);
	}
	

	public void removeReaction(Reaction reaction){
		this.reactions.remove(reaction);
	}
	
	public void removeTangible(Tangible tangible) {
		if (tangibles != null) {
			this.tangibles.remove(tangible);
		}
	}
	
	public boolean isEmptyTangible(){
		return (tangibles != null);
	}
	
	public boolean isEmptyReaction(){
		return (reactions == null);
	}
	public boolean isEmpty(){
		return (this.tangibles != null);
	}
	
	public char showAs(){
		for (Tangible elt : tangibles) {
			if (elt instanceof Player) {
				return elt.showAs();
			}
		}
		return this.tangibles.get(tangibles.size()-1).showAs();
	}
	public void addReaction(Reaction reaction) {
		this.reactions.add(reaction);
		
	}
}

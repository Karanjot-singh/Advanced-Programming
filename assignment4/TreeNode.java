package assignment4;

import java.util.ArrayList;

public class TreeNode {
	private Integer data;
	private ArrayList<TreeNode> children;

	public TreeNode() {
		this.setData((int) (Math.random() * 1000000 + 1));
		System.out.println(this.getData());
		this.children = new ArrayList<>();
	}

	public Integer getData() {
		return data;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}

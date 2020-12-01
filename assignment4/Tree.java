package assignment4;

public class Tree {
	static final private Integer MAX_CHILDREN = 5;
	public int height;
	private Integer numberOfNodes;
	private TreeNode root;

	public Tree(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
		this.root = new TreeNode();
		this.height = 0;
	}

	public static Integer getMaxChildren() {
		return MAX_CHILDREN;
	}

	public TreeNode getRoot() {
		return root;
	}

	public int getHeight() {
		return height;
	}


	public int getRandomNumber(int maxNumber) {
		if (maxNumber == 0) {
			return 0;
		}
		return (int) (Math.random() * maxNumber + 1);
	}

	public void generateTree() {
		this.generateTree(this.root, 0, this.numberOfNodes - 1);
	}

	public void generateTree(TreeNode node, int height, int numberOfNodes) {
		if (numberOfNodes < 0) {
			return;
		}

		this.height = Math.max(this.height, height);

		int numberOfChildren = Math.min(getRandomNumber(getMaxChildren()), numberOfNodes);
		numberOfNodes -= numberOfChildren;

		for (int i = 0; i < numberOfChildren; i++) {
			int nodesOfChild = 0;
			if (i == numberOfChildren - 1) {
				nodesOfChild = numberOfNodes;
			} else {
				nodesOfChild = getRandomNumber(numberOfNodes); //all recursive subnodes of child
				numberOfNodes -= nodesOfChild;
			}
			TreeNode child = new TreeNode();
			node.getChildren().add(child);
			generateTree(child, height + 1, nodesOfChild);
		}
	}
}
#include <iostream>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

struct  Node {
	Node(long long key = 0)
		: Key(key), height(0), weight(0), halfwayLength(0) {
	}

	long long Key;
	long long height;
	long long weight;
	long long halfwayLength;
	Node* Left = nullptr;
	Node* Right = nullptr;
};

class Tree {
public:
	Tree()
		: Root(nullptr), Treelength(0), Treeweight(0) {
	}

	~Tree() {
		DestroyNode(Root);
	}

	void Insert(long long x);

	void Delete(long long& key);

	void height_vertex();

	void height_vertex(Node* node);
	void halfway_node(Node*& max_node, Node* node, long long& half_height, long long& half_weight);

	void del_center(Node* node, Node* max_node, long long& center, long long& counter_l, long long& counter_r);

	std::ostream& PrintPostO(std::ostream& os) const;
	std::ostream& PrintPostO(std::ostream& os, Node* t) const;

	Node* Root = nullptr;
	long long Treelength;
	long long Treeweight;

private:
	static void DestroyNode(Node* node) {
		if (node) {
			DestroyNode(node->Left);
			DestroyNode(node->Right);
			delete node;
		}
	}

};

void Tree::Insert(long long x) {
	Node** cur = &Root;
	while (*cur) {
		Node& node = **cur;
		if (x < node.Key) {
			cur = &node.Left;
		} else if (x > node.Key) {
			cur = &node.Right;
		} else {
			return;
		}
	}
	*cur = new Node(x);
}

std::ostream& Tree::PrintPostO(std::ostream& os) const {
	return PrintPostO(os, Root);
}


std::ostream& Tree::PrintPostO(std::ostream& os, Node* node) const {
	if (node) {
		os << node->Key << "\n";
		PrintPostO(os, node->Left);
		PrintPostO(os, node->Right);
	}
	return os;
}

void Tree::Delete(long long& key) {
	Node** pptr = &Root;
	Node* ptr = Root;
	while (ptr != nullptr && key != ptr->Key) {
		if (key < ptr->Key) {
			pptr = &ptr->Left;
			ptr = ptr->Left;
		} else if (key > ptr->Key) {
			pptr = &ptr->Right;
			ptr = ptr->Right;
		}
	}
	if (ptr == nullptr) {
		return;
	}
	if (ptr->Left != nullptr && ptr->Right != nullptr) {
		pptr = &ptr->Right;
		Node* p = ptr->Right;
		while (p->Left != nullptr) {
			pptr = &p->Left;
			p = p->Left;
		}
		ptr->Key = p->Key;
		if (p->Left != nullptr) {
			*pptr = p->Left;
		} else {
			*pptr = p->Right;
		}
		delete p;
	} else {
		if (ptr->Left != nullptr) {
			*pptr = ptr->Left;
		} else {
			*pptr = ptr->Right;
		}
		delete ptr;
	}
}

void Tree::height_vertex() {
	height_vertex(Root);
}

void Tree::height_vertex(Node* node) {
	if (node) {
		height_vertex(node->Left);
		height_vertex(node->Right);
		if (!node->Left && !node->Right) {
			node->height = 0;
			node->halfwayLength = 0;
			node->weight = node->Key;
		} else if (node->Left && node->Right) {
			node->height = std::max(node->Left->height, node->Right->height) + 1;
			node->halfwayLength = node->Left->height + node->Right->height + 2;
			if (node->Right->height >= node->Left->height) {
				node->weight = node->Right->weight + node->Key;
			} else {
				node->weight = node->Left->weight + node->Key;
			}
		} else if (node->Left && !node->Right) {
			node->height = node->Left->height + 1;
			node->weight = node->Left->weight + node->Key;
			node->halfwayLength = node->Left->height + 1;
		} else /*node->Right*/ {
			node->height = node->Right->height + 1;
			node->weight = node->Right->weight + node->Key;
			node->halfwayLength = node->Right->height + 1;
		}
	}
}

void Tree::halfway_node(Node*& max_node, Node* node, long long& half_height, long long& half_weight) {
	if (node) {
		halfway_node(max_node, node->Left, half_height, half_weight);
		halfway_node(max_node, node->Right, half_height, half_weight);
		if (!node->Left && !node->Right) {
			if (node->halfwayLength > half_height) {
				max_node = node;
				half_height = 0;//
				half_weight = node->Key;
			}
		} else if (node->Left && node->Right) {
			if (node->halfwayLength > half_height) {
				half_height = node->halfwayLength;
				max_node = node;
				half_weight = node->Right->weight + node->Left->weight + node->Key;
			} else if (node->halfwayLength == half_height) {
				if ((node->Right->weight + node->Left->weight + node->Key) > half_weight) {
					max_node = node;
					half_weight = node->Right->weight + node->Left->weight + node->Key;
				}
			}
		} else if (node->Left && !node->Right) {
			if (node->halfwayLength > half_height) {
				max_node = node;
				half_height = node->halfwayLength;
				half_weight = node->Left->weight;
			} else if (node->halfwayLength == half_height) {
				if (node->weight > half_weight) {
					max_node = node;
				}
			}
		} else/*r*/ {
			if (node->halfwayLength > half_height) {
				max_node = node;
				half_height = node->halfwayLength;
				half_weight = node->Right->weight;
			} else if (node->halfwayLength == half_height) {
				if (node->weight > half_weight) {
					max_node = node;

				}
			}
		}
	}
}

void Tree::del_center(Node* node, Node* max_node, long long& center,
	long long& counter_l, long long& counter_r) {
	if (node) {
		//проблема в право/лево высота/глубина
		if (node == max_node) {
			if (!node->Left && !node->Right) {
				if (counter_l == counter_r) {
					center = max_node->Key;
				}
			} else if (node->Left && node->Right) {
				if (counter_l == counter_r) {
					center = max_node->Key;//
				} else if (counter_l > counter_r) {
					if (node->Left->height > node->Right->height) {
						max_node = node->Left;
						counter_l--;
						counter_r++;
					} else {
						max_node = node->Right;
						counter_l--;
						counter_r++;
					}
				} else {
					if (node->Left->height > node->Right->height) {
						max_node = node->Left;
						counter_l++;
						counter_r--;
					} else {
						max_node = node->Right;
						counter_l++;
						counter_r--;
					}
				} //end l & r
			} else if (node->Left && !node->Right) {
				if (counter_l == counter_r) {
					center = max_node->Key;//
				} else if (counter_l > counter_r) {
					max_node = node->Left;
					counter_l--;
					counter_r++;
				} else {
					max_node = node->Left;
					counter_l++;
					counter_r--;

				}
			} else/*r*/ {
				if (counter_l == counter_r) {
					center = max_node->Key;//
				} else if (counter_l < counter_r) {
					max_node = node->Right;
					counter_l++;
					counter_r--;
				} else {
					max_node = node->Right;
					counter_l--;
					counter_r++;
				}
			}
		}
		del_center(node->Right, max_node, center, counter_l, counter_r);
		del_center(node->Left, max_node, center, counter_l, counter_r);
	}
}

int main() {
	Tree tree;

	std::ifstream in("in.txt");
	std::ofstream out("out.txt");

	long long x;
	while (in) {
		in >> x;
		tree.Insert(x);
	}
	long long h_l = -1;
	long long h_w = INT_MIN;

	Node* max_node = nullptr;
	tree.height_vertex();
	tree.halfway_node(max_node, tree.Root, h_l, h_w);
	long long center = -1;

	long long counter_l;
	long long counter_r;
	if (max_node->halfwayLength % 2 == 0) {
		if (!max_node->Left && !max_node->Right) {
			counter_l = 0;
			counter_r = 0;
		} else if (max_node->Left && max_node->Right) {
			counter_l = max_node->Left->height + 1;
			counter_r = max_node->Right->height + 1;
		} else if (max_node->Left && !max_node->Right) {
			counter_l = max_node->Left->height + 1;
			counter_r = 0;
		} else if (!max_node->Left && max_node->Right) {
			counter_l = 0;
			counter_r = max_node->Right->height + 1;
		}
		if (counter_r != counter_l) {

			tree.del_center(tree.Root, max_node, center,
				counter_l, counter_r);
			tree.Delete(center);
			tree.Delete(max_node->Key);
		} else if (counter_r == counter_l) {
			tree.Delete(max_node->Key);
		}
	} else {
		tree.Delete(max_node->Key);
	}
	tree.PrintPostO(out);

	return 0;
}
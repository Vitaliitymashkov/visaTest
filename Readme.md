# Task for Java Test
## Ornament for a Tree

To decorate a typical Christmas tree, we use ornaments. And sometimes, we'd like to decorate even further; if the tree permits us. Our condition to decorate further is that, once we use more ornaments, the tree should still have space for at least one more ornament.

A data set is provided as a string array, where each entry is denotes "tree_id count info_type". Values are separated by a single space.

• The tree_id and count are made of digits, that are at most 9 digits long and start as non-zero digit.

• count represents the number of ornaments which could mean the number of existing ornaments on the tree, or the tree's max capacity of ornaments.

• info_type will be either "used_ornaments" or "max_capacity". Hence, for each tree, depending on info_type you might get information about either number of ornaments used on this tree, or the max capacity of this very same tree.

Remember, we are looking to find out about the Christmas trees which won't permit us using more ornaments.

**Input**

Data:

    "30 99 used_ornaments",
    "30 105 max_capacity",
    "12 100 used_ornaments",
    "20 80 used_ornaments",
    "12 120 max_capacity",
    "20 101 max_capacity",
    "21 110 used_ornaments"

NewOrnaments:

    20
    
**Output**

    [12, 30]



### Explanation


After parsing of all command the data structure will look like this table 

| ID | Used | Max Cap. | Remaining Space |
|----|------|----------|-----------------|
|30 | 99 | 105 | 6 |
|12 | 100 | 120 | 20|
|20 | 80 | 101 | 21 |
| 21 | 120 | | |


The trees with id's 30 and 12 cannot be decorated further for more than newOrnamentsToAdd = 20 ornaments. In sorted numerical order, the return array is ["12", "30"].

### Function Description

Complete the function processChristmasTrees

The function has the following parameter(s):

string data[n]: each data[i] denotes the i-th entry in the data.
int newOrnamentsToAdd: the number of new Ornaments which we want to add.


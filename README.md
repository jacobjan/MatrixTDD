Find the shortest cost in matrix.  Start from leftmost column traverse through adjacent rows
till the cost ( values of element in matirx ) greater than preset limit ( 50 in our examle )
or reach the destination ( rightmost column ).

To run test:

app > src > test, right click on 'MatrixShortestPathTest' then Run it.

The test data files are in project root folder in format:

n ( row )
m ( column )
a11 a12 ... a1m
a21 a22 ... a2m
.
.
an1 an2 ... anm


'''14.3 US GDP (optional)
Description: There are a large number of federal agencies, such as the Department of the Treasury and Office of Management and Budget, who produce official financial statistics which are used by the government to set policy, banks to set rates, and investors to buy and sell equities. The GDP.csv ​file contains information compiled by the Federal Reserve Bank of St. Louis and available via the ​Federal Reserve Economic Data (FRED) portal.

This file, like the last one, contains multiple columns of data but instead of being separated by tabs this is a comma separated value (CSV) which means each column in a row is separated by a single comma.
The data set contains two columns, the first of which is the year month and day that the GDP was announced and the second is the GDP amount in billions.

Compute the average GDP to generate the output shown below. Note the additional dollar sign ($) at the beginning of the value and the “billion” added to the end.
Sample Output:
Average GDP: $5931.592459930313 billion

Note that this file is CSV, meaning it is comma delimited. Also note that the file contains a CSV header at row 0 which will need to be skipped. You were shown at least 1 way to do this in lecture. For example, you can use a combination of ​readlines()​ and slicing to allow you to iterate over all except the line at position 0.'''

with open("GDP.csv", "r") as fileHandle:
    lines = fileHandle.readlines()
    
dgpAverage = 0
# your code goes below here
'''14.1 NASA Temperature Anomalies Data
Both the National Aeronautic and Space Administration (NASA) and the National Oceanic and Atmospheric Administration (NOAA) are excellent sources for free and accurate environmental and temperature data. The ​Global_Temperature_Data_File.txt (you can download this below) is the ​global temperature anomaly data​ available through NASA’s website and has not been modified for this assignment. This data represents “​the change in global surface temperature relative to 1951-1980 average temperatures” and includes both land and ocean temperatures. ​

The file is TAB delimited, and has several columns:
    The first column is the year of the temperature reading.
    The middle column represents the anomaly in the land temperatures for that year.
    The last column represents the anomaly in the ocean temperatures for that year.

You are asked to compute the average of both land temperature and ocean temperature based on given data (we provided a sample output below for reference). You will also need to use additional functions (such as ​split()​) in order to access the different values in the row (remember you can use ​\t​ as a separator to split strings based on tabs, which is how the data in this file is separated).
For example, to read the lines in file we would open the file and read lines, and then loop through each line and split by separator, which is a "\t" meaning a tab.
Your job is to complete this code to compute the average land temperature and average ocean temperature. Note, to compute the average of land temperature for example, you should compute the sum of all land temperature values and then divide by the number of readings, which is given by variable numReadings.
Once you have calculated the average temperatures, you will need to calculate the ​variance​ of the values in the file for each column. The most useful equation for finding variance is below. When you calculate variance, print it out in addition to the values above with the following text. Note, you may need 1 loop to compute the average, then a second loop to compute the variance.

Computing variance

Sample output
Average land temperature anomaly: 0.025869565217391366
Average ocean temperature anomaly: 0.026594202898550783
Land temperature anomaly variance: 0.1101645668041892
Ocean temperature anomaly variance: 0.10307371733841113'''

with open("Global_Temperature_Data_File.txt", "r") as fileHandle:
    # open file 
    lines = fileHandle.readlines() # read all lines into variable 

numReadings = len(lines) # number of temperature readings = number of lines in the file

# next, loop through each line in the file and split line by separator
avgOceanTemp = 0
avgLandTemp = 0 
for line in lines: 
     year, landTemp, oceanTemp = line.split("\t")
     # TODO  - convert landTemp and oceanTemp to floats and compute averages
     landTemp = float(landTemp)
     oceanTemp = float(oceanTemp)
     
     avgLandTemp += landTemp
     avgOceanTemp += oceanTemp
     
# TODO  - write code to compute average of land temp and ocean temp and print results
avgLandTemp /= numReadings
avgOceanTemp /= numReadings

print ("Average land temperature anomaly: ", avgLandTemp )
print ("Average ocean temperature anomaly: ", avgOceanTemp )

landVariance = 0
oceanVariance = 0
for line in lines: 
     year, landTemp, oceanTemp = line.split("\t")
     # TODO  - write code to compute average of variance 
     landTemp = float(landTemp)
     oceanTemp = float(oceanTemp)
     
     landVariance += (landTemp - avgLandTemp) ** 2
     oceanVariance += (oceanTemp - avgOceanTemp) ** 2

landVariance /= (numReadings - 1)
oceanVariance /= (numReadings - 1)

# TODO - print the variance of land temp and ocean temp 
print ("Land temperature anomaly variance: ", landVariance)
print ("Ocean temperature anomaly variance: ", oceanVariance) 
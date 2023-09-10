import matplotlib.pyplot as plt
infile = open('list_vs_map_results.txt', 'r')
infile.readline()

x_arr = []
y1_arr = []
y2_arr = []

for line in infile:
    (x, y1, y2) = line.split()
    x_arr.append(int(x) / 1000)
    y1_arr.append(float(y1))
    y2_arr.append(float(y2))
    
plt.xlabel("Collection size, 1000s of items")  # add X-axis label
plt.ylabel("Time to complete contains operation (sec)")  # add Y-axis label

plt.plot(x_arr, y1_arr, label = "ArrayList", linestyle="dashed")
plt.plot(x_arr, y2_arr,  color="#800000", label = "HashMap", linestyle="dotted")
plt.legend()
plt.show()

infile.close()
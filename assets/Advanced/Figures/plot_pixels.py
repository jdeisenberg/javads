from PIL import Image
import matplotlib.pyplot as plt
import numpy as np 

fig = plt.figure()
ax1 = fig.add_subplot(111,projection='3d')

finished = False
while not finished:
    filename = input('Enter input file name: ')
    if filename != '':
        im = Image.open(filename)
        xs = []
        ys = []
        zs = []
        pixel_data = list(im.getdata())
        for pixel in pixel_data:
            xs.append(pixel[0])
            ys.append(pixel[1])
            zs.append(pixel[2])
           
        ax1.scatter(xs,ys,zs,s=1)
        ax1.set_title('Plot of Colors Used in Sample Image as Points in Color Cube')
        ax1.set_xlabel('Red')
        ax1.set_ylabel('Green')
        ax1.set_zlabel('Blue')
        plt.show()
            
    else:
        finished = True

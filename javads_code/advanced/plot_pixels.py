from PIL import Image
import matplotlib.pyplot as plt
import numpy as np 


finished = False
while not finished:
    filename = input('Enter input file name: ')
    if filename != '':
        dict = {}
        n_values = 0
        im = Image.open(filename)
        xs = []
        ys = []
        zs = []
        pixel_data = list(im.getdata())
        for pixel in pixel_data:
            xs.append(pixel[0])
            ys.append(pixel[1])
            zs.append(pixel[2])
            value = (pixel[0] << 16) | (pixel[1] << 8) | (pixel[2])
            # print(value)
            if value in dict:
                dict[value] = dict[value] + 1
                # print("saw already")
            else:
                dict[value] = 1
                n_values = n_values + 1
        
        print("# of values:", n_values)
        fig = plt.figure()
        ax1 = fig.add_subplot(111,projection='3d')
        ax1.scatter(xs,ys,zs,s=1)
        ax1.set_title('Plot of Colors Used in Sample Image as Points in Color Cube')
        ax1.set_xlabel('Red')
        ax1.set_ylabel('Green')
        ax1.set_zlabel('Blue')
        plt.show()
            
    else:
        finished = True

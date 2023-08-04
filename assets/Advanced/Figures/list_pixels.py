from PIL import Image

finished = False
while not finished:
    filename = input('Enter input file name: ')
    if filename != '':
        out_filename = input('Enter output file name: ')
        im = Image.open(filename)
        out_file = open(out_filename, 'w')
        pixel_data = list(im.getdata())
        for pixel in pixel_data:
            out_file.write(f'{pixel[0]},{pixel[1]},{pixel[2]}\n')
            
        out_file.close()
    else:
        finished = True

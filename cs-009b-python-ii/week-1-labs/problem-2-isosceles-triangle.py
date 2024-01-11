def draw_triangle(width, max_value):
    # Draw upside-down isosceles triangle
    # Function calls itself at the end of this function
    # Triangle has 2 matching sides
    # width is odd

    if width < 1:
        return

    # spacing = (width - 1) // 2
    spaces = (max_value - width) // 2

    print(' ' * spaces + '*' * width)
    draw_triangle(width - 2, max_value)


value = 5
draw_triangle(value, value)

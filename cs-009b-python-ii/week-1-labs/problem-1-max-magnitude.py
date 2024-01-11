# Transfer over to PyCharm

def max_magnitude(num_list):
    # Given (a, b, c), find the max magnitude
    max_val = -1

    for i in num_list:
        # if negative: multiply by -1
        if i < 0:
            i = i * -1

    for k in num_list:
        # if current_val > max_val: max_val = current_val
        if k > max_val:
            max_val = k

    return max_val


def main():
    num_list = [1, 4, 7]
    max_magnitude(num_list)

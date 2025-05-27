class Solution:
    def reverseBits(self, n: int) -> int:
        result = 0
        for i in range(32):  # Since we're dealing with 32-bit unsigned integers
            bit = (n >> i) & 1
            # Shift the input number `n` to the right by `i` positions
            # This brings the i-th bit to the least significant bit (LSB) position
            # AND with 1 to isolate just that bit (0 or 1)

            result |= (bit << (31 - i))
            # Shift that bit to its reversed position (e.g., bit 0 goes to position 31)
            # Then use bitwise OR to set it in the result

        return result  # Return the final reversed 32-bit integer

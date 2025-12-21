class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # for each candidate -> find the paths to that value and repeat for all values below target?

        # recursively go over every candidate to see if it results in the target
        # if it does - store the path, if it doesnt - continue from that same value to another path
        result = []

        def bt(start_index, current_path, current_sum):
            if current_sum == target:
                result.append(current_path.copy())
                return
            if current_sum > target:
                return

            # explore candidates from current index repeatedly with all paths
            for i in range(start_index, len(candidates)):
                candidate = candidates[i]
                # new path for each iteration
                path = current_path.copy()

                path.append(candidate)

                bt(i, path, current_sum + candidate)


        bt(0, [], 0)
        return result
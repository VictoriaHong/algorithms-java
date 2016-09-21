// Rectangle Area
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // A, E w_left max
        // C, G w_right min
        // B, F h_low max
        // D, H h_hi min
        
        int wl = Math.max(A, E);
        int wr = Math.max(Math.min(C, G), wl); // if no overlap, wr < wl, then wr-wl should be 0
        int hl = Math.max(B, F);
        int hh = Math.max(Math.min(D, H), hl);
        
        return (C - A) * (D - B) - (wr - wl) * (hh - hl) + (G - E) * (H - F);
    }
}

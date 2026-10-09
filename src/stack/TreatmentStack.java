package stack;

import model.Treatment;
import java.util.ArrayList;
import java.util.List;

public class TreatmentStack {

    private List<Treatment> stack;

    public TreatmentStack() {
        stack = new ArrayList<>();
    }

    public void push(Treatment treatment) {
        stack.add(treatment);
        System.out.println("Treatment record pushed: " + treatment.getTreatmentId());
    }

    public Treatment pop() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty!");
            return null;
        }
        Treatment t = stack.remove(stack.size() - 1);
        System.out.println("Popped treatment: " + t.getTreatmentId());
        return t;
    }

    public Treatment peek() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty!");
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return;
        }
        System.out.println("--- Treatment History (Most Recent First) ---");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }
}
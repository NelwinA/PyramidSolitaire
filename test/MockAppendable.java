import java.io.IOException;

/**
 * Represents a mock appendable for testing the IOException in append.
 */

public class MockAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("MockAppendable");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("MockAppendable");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("MockAppendable.");
  }
}

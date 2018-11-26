package io.opencensus.trace;

import io.opencensus.common.Scope;
import java.util.concurrent.Callable;

public class ScopeManagerImpl implements ScopeManager {
  @Override
  public Span activeSpan() {
    return CurrentSpanUtils.getCurrentSpan();
  }

  @Override
  public Scope withSpan(Span span) {
    return CurrentSpanUtils.withSpan(span, /* endSpan= */ false);
  }

  @Override
  public Scope withSpan(Span span, boolean finishSpanOnClose) {
    return CurrentSpanUtils.withSpan(span, finishSpanOnClose);
  }

  @Override
  public Runnable withSpan(Span span, boolean finishSpanOnClose, Runnable runnable) {
    return CurrentSpanUtils.withSpan(span, finishSpanOnClose, runnable);
  }

  @Override
  public <C> Callable<C> withSpan(Span span, boolean finishSpanOnClose, Callable<C> callable) {
    return CurrentSpanUtils.withSpan(span, finishSpanOnClose, callable);
  }
}

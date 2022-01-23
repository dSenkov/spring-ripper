package org.roadtosenior.springripper.infrastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfilingController implements ProfilingControllerMBean {

  private boolean enabled = true;
}

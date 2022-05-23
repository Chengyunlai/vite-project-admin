package top.chengyunlai.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
  private Integer id;
  private String username;
  private String password;
  private String telephone;
  private String email;
  private Integer role;
}

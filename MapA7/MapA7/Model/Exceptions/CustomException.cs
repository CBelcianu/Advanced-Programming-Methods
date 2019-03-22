using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapA7.Model.Exceptions
{
    public class CustomException:Exception
    {
        public CustomException(String message) : base(message){ }
    }
}

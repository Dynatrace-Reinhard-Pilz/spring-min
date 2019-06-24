from ruxit.api.base_plugin import BasePlugin
from ruxit.api.snapshot import pgi_name


class MiniPlugin(BasePlugin):
    def query(self, **kwargs):
        pgi = self.find_single_process_group(pgi_name('springmin.Application'))
        pgi_id = pgi.group_instance_id
        self.results_builder.absolute(key='random', value=1.0, entity_id=pgi_id)
        self.results_builder.relative(key='counter', value=1.0, entity_id=pgi_id)